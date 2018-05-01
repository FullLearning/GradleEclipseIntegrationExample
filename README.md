# Gradle and App Engine Plugin Integration with Eclipse

In our organization, many teams explored adopting Gradle as their automated build tool for use with continuous integration servers, such as Jenkins.  This video, [Using Gradle, the App Engine Plugin, and Eclipse - Google App Engine Standard Java](https://www.useloom.com/share/fed2ee29615543f6923b272076832c0f), walks us through the process of setting up a Java project from scratch, integrating it with Gradle, App Engine, and then integrating it with Eclipse.


###Step 1:  

- In this documentation,[Using Gradle and the App Engine Plugin](https://cloud.google.com/appengine/docs/standard/java/tools/gradle), perform the steps 1 through 4 in section titled "Creating a new Gradle Project"

- For step 4 in the documentation, we need to add a source file in /src/main/java called [HelloAppengine.java](https://github.com/FullLearning/GradleEclipseIntegrationExample/wiki/HelloAppEngine.java-Initial-File).


###Step 2:  

- In order to integrate with Eclipse, create a Java Project, and use the same name as the project you created in the previous steps.  This adds the .project file and adds the project in Eclipse.


###Step 3: 

- Edit the web.xml file to configure HelloAppEngine servlet.

###Step 4: 

- Edit appengine-web.xml file to use java 8 runtime by adding the following entry:

```
   <runtime>java8</runtime>
```

###Step 5:  

- Run "gradle test". If all goes well, run "gradle appengineRun". This should start the server.  Go to [http://localhost:8080/hello](http://localhost:8080/hello) to see the "hello world!" output.

###Step 6: 

- In Eclipse, you'll still _may_ see compile errors. This is because the classpath has not been configured in Eclipse, only gradle.  We resolve this by adding the Eclipse plugin in gradle.build file.

```
    apply plugin: 'eclipse'
```

- Once added, run "gradle eclipseClasspath" then refresh the project in eclipse with F5.  This adds the src/main/java and src/test/java as source folders inside Eclipse as well as configures other classpath items.


###Step 7:  

Configure Eclipse to see the project as an App Engine project:

- Right click the project name, select "Configure" and "Convert to App Engine Standard Project"

You can now debug the project from within Eclipse with "Debug As -> App Engine" option


###Additional Exercises

- In the video, we added in log4j dependencies.  Here is the link to the [sample log4j.properties configuration file](https://github.com/FullLearning/GradleEclipseIntegrationExample/wiki/log4j.properties-Sample-File), which you must place in src/main/resources

- Here is the [modified HelloAppEngine.java file](https://github.com/FullLearning/GradleEclipseIntegrationExample/wiki/HelloAppEngine.java-Modified-File-to-use-Log4j-and-Jsoup-to-Parse-Wikipedia-News-articles) using log4j and Jsoup to parse content pulled from Wikipedia.  

- Documentation for log4j where I put together the examples are found thanks to [this Stack Overflow answer](https://stackoverflow.com/a/4370296/552792).
