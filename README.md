# Dependency Injection From Scratch

___Original Source: https://dev.to/martinhaeusler/understanding-dependency-injection-by-writing-a-di-container-from-scratch-part-1-1hdf___ 

Baby steps in Java for understanding Dependency Injection.

## DI Stage 0: Basic example

* Code is very poor in terms of OO principles. services.ServiceA and services.ServiceB should, at the very least, be
objects.
* The code is tightly coupled and very hard to test in isolation.
* We have absolutely no chance of swapping neither services.ServiceA nor services.ServiceB with a different
implementation. Imagine one of them is doing credit card billings; you **don't** want that to actually happen in your 
test suite.
  
## DI Stage 1: Getting rid of static references

### Improvements

* We can now replace the implementation of `services.ServiceB` which is used by `services.ServiceA` by providing another 
object, potentially even of another subclass.
* We can test both services in isolation with a proper test mock for services.ServiceA

### Problems

* It's hard to create mocks, as we require a __class__.
* It would be much nicer if we require __interfaces__ instead. Also, this would further reduce the coupling.

## DI Stage 2: Using interfaces

* As your project gets bigger, it will become more and more complex to __create the network of services__ inside your
`main()` method.
* your will encounter __cycles__ in your service dependencies which cannot be resolved using constructors as shown in
our example.
  

