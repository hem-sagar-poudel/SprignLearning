# add this in application.properties

spring.profiles.active=dev

# multiple profiles properties active. in any order

spring.profiles.active=dev,test,custom //

# also can be defined in root class

var app = new SpringApplication(ExampleApplication.class);
app.setDefaultProperties(Collections.singletonMap("spring.profile.active", "dev"));
var context = app.run();
