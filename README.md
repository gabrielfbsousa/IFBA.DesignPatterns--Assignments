![College](https://img.shields.io/badge/College-IFBA-green)
![Language](https://img.shields.io/badge/Language-Java-orange)
![IDE](https://img.shields.io/badge/IDE-Netbeans-lightblue)


# Design Patterns :: Assignments
Assignments developed and delivered for the course of Design Patterns, on fourth term of the System's Analysis and Development program, at Instituto Federal da Bahia. All the programs below were written in Java, using a Plugin-based architecture

#### Project Information
- Project: ``Assignments of Design Patterns``
&nbsp;

- Course code: ``INF-011``
&nbsp;

- Status: ``Completed``
&nbsp;

- Technology: ``Java``
&nbsp;

- Date: ``Dec 2014``
&nbsp;

## Session 1 - Prototype
### Details
This session aimed to implement the Prototype pattern, that should return to us an instance of each sub-type when called their method Clone(), inherited from their parent IPrototype. The goal was to mount a fake PC, with pieces (Processor, Memory and Disk) of each retailer (Apple, HD and Lenovo). When calling for one PC, Abstract Factory should be used to help, mounting an instance of the PC specifically with all that same brand's parts.

## Session 2 - Abstract Factory
### Details
The goal for this session was to implement a new Plugin into the Editor Framework we were developing during classes. For this, we should implement Abstract Factory pattern, in a way that our Social Network Plugin should implement a Plugin Interface and create new buttons at the GUI for sharing the editor's content into Facebook, Tweet, Google+ and LinkedIn.

## Session 3 - Singleton
### Details
The objective of this session was to implement Singleton into the main controllers and the core of the Editor Framework. The idea is that those classes are unique, and won't need to be instanced over the cycle of the program's execution. For this, Singleton was implemented, giving the same instance that was once initialized, preventing us to try to instantiate another core functionallity.

## Session 4 - Bridge
### Details
The goal for this session was to implement a helper functionallity into the Editor Framework. However, there should be displayed the Help's information on how to work at the Editor with each of the four different types: Image, PDF, Text and Video. Not only that, but each of those types should have the information displayed at the interface in each of the types too. In other words, if you want the information on how to deal with Image at the Editor, you'll have this specific information available in Image, PDF, Text and Video formats. If you want to work with PDF, you'll have this information on how to work with it in each of the four formats as well, and so on

In order to do that, it should be used the Bridge design pattern, in addition to Abstract Factory. This Helper funcitonallity should also be a Plugin, so that the Editor can start without it, and only load it if available.

## Session 5 - Iterator
### Details
The objective of this activity was to implement a customized Iterator, in which we should be able to navigate into ArrayLists and LinkedLists, under a custom rule.


--- 
Made by Gabriel Ferreira :computer: [Find me at Linkedin!](https://www.linkedin.com/in/gabriel-f-sousa/)
