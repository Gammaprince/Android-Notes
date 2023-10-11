suspend function is used to receive single object , so if we have scenerio where we just want data from server or from api for once then suspend function is good choice 
but in case of continuos stream or data we can't use suspend function , because suspend function can only return one time object and after that it destroy or stop.

so in cases of continuos stream we use Channels & Flows 
  Channels -> They are hot in nature : means they don't care if there is any consumer who is consuming or not , they just send the data 
  Flows -> Flows are mostly cold : means they would not emit data until or unless somebody is consuming.
Channels and Flows work asynchronosly so they need coroutines to execute. so when consuming we need to consume it in inside coroutine scope , see when producing we also need coroutines and suspend functions.
  for eg-> 
  var list = Channel<Int>();
  onCreate(){
    producer();
    consumer();
  }

  fun producer(){
    // to producing we need coroutines as well.
    CoroutineScope(Dispatchers.Main).launch{
      channel.send(1);
      channel.send(2);
    }
  }

 fun consumer(){
   // for consuming we need coroutines as well
   CoroutineScope(Dispatchers.Main).launch{
     Log.d("TAG",channel.receive().toString());
   }
 }
