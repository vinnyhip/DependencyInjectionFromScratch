# Dependency Injection From Scratch

___Original Source: https://dev.to/martinhaeusler/understanding-dependency-injection-by-writing-a-di-container-from-scratch-part-1-1hdf___ 

Baby steps in Java for understanding Dependency Injection.

## DI Stage 0: Basic example

* Code is very poor in terms of OO principles. main.services.ServiceA and main.services.ServiceB should, at the very least, be
objects.
* The code is tightly coupled and very hard to test in isolation.
* We have absolutely no chance of swapping neither main.services.ServiceA nor main.services.ServiceB with a different
implementation. Imagine one of them is doing credit card billings; you **don't** want that to actually happen in your 
test suite.
  
## DI Stage 1: Getting rid of static references

### Improvements

* We can now replace the implementation of `main.services.ServiceB` which is used by `main.services.ServiceA` by providing another 
object, potentially even of another subclass.
* We can test both main.services in isolation with a proper test mock for main.services.ServiceA

### Problems

* It's hard to create mocks, as we require a __class__.
* It would be much nicer if we require __interfaces__ instead. Also, this would further reduce the coupling.

## DI Stage 2: Using interfaces

* As your project gets bigger, it will become more and more complex to __create the network of services__ inside your
`main()` method.
* your will encounter __cycles__ in your service dependencies which cannot be resolved using constructors as shown in
our example.
  
## DI Stage 3: Breaking the cycle with setters

* Doing the wiring part manually is error prone. You might forget to call a setter and then it's `NullPonterException`
galore.
* You might accidentally use a service instance that is still under construction, so it would be beneficial to
encapsulate the network construction somehow.
  
## DI Stage 4: Automating the wiring

### Improvements

* Service get wired together automatically.
* We can no longer forget to call a setter (in fact, we don't need them anymore).
* Our application will fail __on startup__ if the wiring fails, not during the business logic.

### Problems

* We want to have the ability to access __every__ service in the network, not just one.

## DI Stage 5: Encapsulating the Context

### Improvements

* We now can easily pull out any service instances from the context by calling `getServiceInstance`
* The main.services itself can access each other simply by declaring a field of the proper type
* The main.services don't even have to know about the `DIContext` object.

### Problems

* We need a way to __tell our algorithm__ which fields we want it to set and which ones to leave alone.  

## DI Stage 6: Annotating fields

### Improvements

* Now the __algorithm knows__ which fields it needs to assign 

### Problems

* How we can actually discover our service classes?

## DI Stage 7: Auto-detecting Services

* Our classpath scanner will detect all classes and decide if they are services or not.

