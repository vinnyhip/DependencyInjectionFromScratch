# Dependency Injection From Scratch

___Original Source: https://dev.to/martinhaeusler/understanding-dependency-injection-by-writing-a-di-container-from-scratch-part-1-1hdf___ 

Baby steps in Java for understanding Dependency Injection.

DI Stage 0

* Code is very poor in terms of OO principles. ServiceA and ServiceB should, at the very least, be objects.
* The code is tightly coupled and very hard to test in isolation.
* We have absolutely no chance of swapping neither ServiceA nor ServiceB with a different implementation. Imagine one of
them is doing credit card billings; you **don't** want that to actually happen in your test suite.
  
