need of architecture ? 
Scalability and maintainibility of an application , to achieve this we use architecture patterns like MVVM , MVC , MVP.

Architecture patterns mainly focuses on 
  1-> Separation of concerns - we break every working into different componenets like UI layer , BusinessLogic Layer , API , Repositories
  2-> Unit Testing

MVC -> is single architecture pattern , it is default architecture when we made new project in android studio.in MVC we break app in 3 layers 
         View(layout files(xml)) - Controller(Activity / Fragment ) - Model(Data classes , POJO etc)
 in this pattern if some event happen like button click then view will update to controller and then controller update Model and then Model update Activity and Activity update View
. for small application this app is good but for larger application this architecture mess up things , because here there is no sepearation of concerns , means
controller is heavly dependent over view and vice versa. we can use MVP pattern for bigger application.

MVP ->                    View(layout files , Activity/Fragment) <-> Presenter <-> Model(POJO , Data classes etc)

       in this pattern layout files and Activity and Fragment consider as View and we define all business logic inside Presenter . lets understand with example 
// Model representing the data (counter value)
class CounterModel {
    private var counter = 0

    fun increaseCounter() {
        counter++
    }

    fun decreaseCounter() {
        counter--
    }

    fun getCounter(): Int {
        return counter
    }
}

// View interface defining methods to be implemented by the Activity
interface CounterView {
    fun showCounter(counter: Int)
}

//Implementing Presenter
class CounterPresenter(private val view: CounterView) {
    private val model = CounterModel()

    fun increaseCounter() {
        model.increaseCounter()
        view.showCounter(model.getCounter())
    }

    fun decreaseCounter() {
        model.decreaseCounter()
        view.showCounter(model.getCounter())
    }
}


// Implementing the Activity
class CounterActivity : AppCompatActivity(), CounterView {
    private lateinit var counterTextView: TextView
    private lateinit var presenter: CounterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        counterTextView = findViewById(R.id.counterTextView)
        val increaseButton = findViewById<Button>(R.id.increaseButton)
        val decreaseButton = findViewById<Button>(R.id.decreaseButton)

        // Create a presenter instance, passing the View (CounterActivity) to the presenter
        presenter = CounterPresenter(this)

        // Set click listeners for increase and decrease buttons
        increaseButton.setOnClickListener {
            // Call the presenter method to increase the counter
            presenter.increaseCounter()
        }

        decreaseButton.setOnClickListener {
            // Call the presenter method to decrease the counter
            presenter.decreaseCounter()
        }
    }

    // Implementation of CounterView interface method to show the counter value
    override fun showCounter(counter: Int) {
        counterTextView.text = counter.toString()
    }
}


/*
So basically Interfaces are used to interact b/w presenter and Acitivity/Fragment . Thing which i was not know that there is no need to typecast a class instance 
if interface is implemented and we referrence to implemented interface like , in java , it handles implicitly , but in koltin this also handles automatically.

See above code in detail to understand MVP model , chatGPT helped me to clearly understand this topic , so make sure read above code carefully

whenever we want to send update data to Presenter use Presenter functions and whenever Presenter needs data of Activity or Fragment then use implemented functions of interface in presenter by Activity;
By using this we are actually making Presenter and View/Fragment/Activity losely couped so code can be easily maintanable and scalabe and also can easily be tested separately
we are using separation of concerns here , unlike to the MVC pattern
*/


MVVM -> Now lets talk about MVVM architecture pattern


        
