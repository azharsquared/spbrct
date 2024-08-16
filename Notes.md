## DI

> DI allows for loose coupling between components, making your code more
flexible, maintainable, and testable

3 types are there

-  service is a class that can be used (this is the dependency).
-  client is a class that uses the dependency.
-  injector passes the dependency (the service) to the dependent class (the client).


> ### its easy to test

types

+ Constructor injection: Dependencies are passed to a client class constructor
  + > // Constructor injection
    public class Car {
    private final CarRepository carRepository;
    public Car(CarRepository carRepository) {
    this.carRepository = carRepository;
    }
  + > / Constructor to used for dependency injection
    @Autowired
    public Car(CarRepository carRepository) {
    this.carRepository = carRepository;
    }



+ Setter injection: Dependencies are provided through setters.
  +  more flexible 
  ```
  @Autowired
  public void setAppUserRepository(
    AppUserRepository userRepository) {
    this.userRepository = userRepository;
    }
  ```

+ Field injection: Dependencies are injected directly into fields (possibility of runtime errors and difficulty to test)
  
  ```
  public class CarController {
  @Autowired
  private CarDatabaseService carDatabaseService;
    //... 
  }
  ```


>  dependency injection is achieved through the ***Spring ApplicationContext***
> > **ApplicationContext** is responsible for creating and managing objects beans and their dependencies.


