The program offers to choose one of following options:
```
1. Play the guessing game
2. List of all animals
3. Search for an animal
4. Calculate statistics
5. Print the Knowledge Tree
0. Exit
```

During the game the program tries to guess the animal that the user keeps in mind. 
When the program meets a new animal, it asks the user a fact about this animal and adds this fact to binary tree. 
Then the program uses facts from binary tree to guess next animal.
Between game sessions the program store knoledge tree in file (json, xml or yaml depends on program parameter -type)

The program can print all facts about chosen animal 
```
Facts about the squirrel:

It is living in a forest.
It has bushy tail.
It can climb a tree.
```

calculate some statistics:
```
The Knowledge Tree stats

- root node                    It is living in a forest.
- total number of nodes        13
- total number of animals      7
- total number of statements   6
- height of the tree           3
- minimum animal's depth       2
- average animal's depth       2.9
```
and print Knowledge tree
```
└ Is it living in a forest?
 ├ Does it have bushy tail?
 │├ Can it climb a tree?
 ││├ a squirrel
 ││└ a fox
 │└ a lynx
 └ Is it mammal?
  ├ Does it have horns?
  │├ a cow
  │└ a cat
  └ Does it have a shell?
   ├ a turtle
   └ a shark
```

If you specify user.language key as "eo" you can play the game in Esperanto :)


### Covered topics
* Binary tree
* Regexps
* Localization
* JSON, XML
