#  Diamond code kata.

##  How to run.

    ./gradlew clean build shadowJar
    java -jar build/libs/diamond-all.jar
    
    # or
    ./gradlew clean build runShadow
    
## About
 
Description: http://claysnow.co.uk/recycling-tests-in-tdd/

Although I find the approach with incremental test refining interesting,
I think the same can be achieved while still keeping old tests.
I you have ever climbed in your life (I haven't), you probably remember
the checkpoints you lock to climbing higher and higher (if you are still alive, you probably do).
When you have made mistake, and either want to pick a different root, or you simply have fallen,
this checkpoint guarantees that you don't fall any lower than necessary. It is also
important to be locked to at least one checkpoint close to you, at any given time.
Otherwise you risk falling long distance, and effectively dying.

Let's now look at the test rewriting approach. A final, correct implementation is our peak we climb.
Any intermediate solution satisfying more requirements is an equivalent of being higher.
Being higher, however, does not necessarily mean being closer to the final solution.
Sometimes we encounter an obstacle preventing us from progressing and we
have to take a step back to find another route.

Let's imagine what happens in this case, when we need to retreat, take a few steps back and take another route.
It's a quite common case, especially when we design an algorithm for the first time and we do it
by test driving it.

In the traditional approach, when you keep previous tests and always run all of them, your safety check
is your previous test that you wrote. Even if it turned out that your last 5 steps were in the wrong direction,
you remove the last 5 tests, one by one, letting yourself to gracefully reach the place that enables you to take
the another route. You cannot fall lower than you planned.

Conversely, when you keep rewriting one and the same test, you climb higher and higher, with your last
checkpoint being also your only one. If it turned out, that our last 5 steps were in the wrong direction,
you simply, well, jump. Which is an equivalent of abandoning the idea and starting from scratch.
You have no previous checkpoint, let alone last five. You try to recall what the last one was.
You can always use version control, if you are lucky to have a habit of committing often, but
this option is easily available only right after you finished the last step. Imagine that you have
to improve the algorithm you worked on a moth or a year ago and you realize that some aspects
of the solution are not fit for purpose any more - good luck with browsing commit history
and trying to revert some changes. You jump.

This is the dark side of this process and most probably the reason why I
 normally do not use this approach. Let's come up with something better.
If you look at the reason why someone even considered taking the rewriting approach.
I guess, from reading the blog, that they were the following.
- going straight to the final solution is too risky with too many intermediate steps skipped
- requirements expressed by the intermediary steps contradict the final solution, i.e. all tests cannot be green at the same time

I completely agree with the former. There is too much risk involved. Besides, small, incremental steps is a cornerstone of TDD.
When it comes to the latter, let's find a better solution than one presented in the above mentioned blog.
