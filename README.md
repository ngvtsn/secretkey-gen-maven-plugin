# secretkey-gen-maven-plugin
Maven plugin for generate a secret key

```xml
    <build>
        <plugins>
            <plugin>
                <groupId>ru.ysn.emsd.maven.plugins</groupId>
                <artifactId>secretkey-gen-maven-plugin</artifactId>
                <version>1.0-SNAPSHOT</version>
                <configuration>
                    <prop-name>secretkey</prop-name>
                </configuration>
                <executions>
                    <execution>
                        <phase>validate</phase>
                        <goals>
                            <goal>secretkeygen</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <filtering>true</filtering>
            </resource>
        </resources>
    </build>
```

````
    ${secretkey}
    @secretkey@ for Spring properties
````

secretkey is prop-name default value.