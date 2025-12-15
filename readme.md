@Service
public class MyFirstService {

private MyFirstClass myFirstClass;

// method injection
@Autowired
// @Qualifier("bean1") can be here also
public void injectDependencies( @Qualifier("bean1") MyFirstClass myFirstClass){
this.myFirstClass = myFirstClass;
}

public String tellAStory(){
return "The dependency is saying : " + myFirstClass.sayHello();
}
