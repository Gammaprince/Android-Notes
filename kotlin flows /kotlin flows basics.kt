
cold strams are preffered over hot streams 
because hot stream , it is resource intensive and we need to manually close hot streams.

Based on requirements we decide which one to use , but generally cold streams are prefferred.

Producer and consumer problem : if consumer consuming data slow and producer sending data too fast or vice versa then this is bottleneck , before developers in android was using Thread blocking method to handle this problem.
                                but now we have coroutines so instead of thread we can suspend coroutines to work more effeceintly.

lets see with code:



onCreate(){
  // every consumer will receive data from start no matter after how many times consumer start to collect
  val job = GlobalScope.launch{
      val data : flows<Int> = producer();
      data.collect{
        Log.d("TAG",it.toString());
      }
    }
  // If we want to cancel flows , we need to cancel coroutines because if no listener is listening then flow would not emit data, to cancel corotine call job.cancel();
  // delay(3500) delay here would block main thread so call it inside corotinescope
  GlobalScope.launch{
     delay(3500);
    job.cancel();
  }
}

// flows<Int> here is lambda function
// Bydefault flows create CoroutineScope 
fun producer() = flows<Int>{
  val list = listOf(1,2,3,4,5,6,7,8);
  list.forEach{
    // for time delay as in real api happens
    delay(1000);
    emit(it);
  }
}
