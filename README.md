# BetterReader - Alpha-2.1.1 #

Born from my own obsessive compulsive need for tidy code comes
BetterReader. A wrapper class for BufferedReaders that offers a nice way to
access data within loops. No more headaches over the following code:
```java
while ((String line = reader.readLine()) != null) {
    // Do something
}

while (true) {
    String line = reader.readLine();
    if (line == null) break;
    // Do something
}

for (String line = reader.readLine(); line != null; line = reader.readLine()) {
    // Do something
}

String line = reader.readLine();
while (line != null) {
    // Do something
    line = reader.readLine();
}
```
Now we can use BetterReader to tidy up our code:
```java
while (reader.hasNext()) {
    line = reader.getLine();
    // Do something
}
```

&copy; 2013 UndeadScythes of UndeadScythes' Empire

Feel free to post issues and suggestions on [GitHub](https://github.com/UndeadScythes/BetterReader).
BetterReader source code is released under the CC BY-NC-SA 2.0 UK license.
A copy of this licence is located in the file named LICENCE.lic, if this file is
not present the text can be found [here](http://creativecommons.org/licenses/by-nc-sa/2.0/uk/legalcode).

Last edited on 2013-09-24.
