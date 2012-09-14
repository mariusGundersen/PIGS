# PIGS - Progress Indicator via Gif Socket

This is based on the gifsocket made by Alvaro Videla: [https://github.com/videlalvaro/gifsockets](https://github.com/videlalvaro/gifsockets).

## How does it work

Go to index.php, and you will see a progressing animated gif. 
The gif generated by the java class Pigs, which uses a delayed loop to add frames to the gif and push them to the client.

The java class could do something else, like uploading a file or transcoding a video, and report the progress to the client via
the gifs.

## How to install

Everything is ready to run, but you might have to build the java classes and set the permission on the pigs.bat and pigs.sh script.

To compile the java run this code: 

```bash
$ javac.exe -classpath java/commons-io-2.4.jar -d classes/ java/*.java
```

You can test the java file by running the following code and opening the generated image in the browser.

```bash
$ cd classes
$ java Pigs noDelay > ../output.gif
```

## Why PHP/Java?

This is a program that uses gifsockets and you want to know why I used PHP and Java?

## Source

Some of the Java code is from [http://www.fmsware.com/stuff/gif.html](http://www.fmsware.com/stuff/gif.html)