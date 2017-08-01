package ru.ysn.emsd.maven.plugins;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Mojo(name = "secretkeygen")
public class SecretKeyGeneratorMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}")
    private org.apache.maven.project.MavenProject project;

    @Parameter(property = "prop-name", defaultValue = "secretkey")
    private String propName;

    public void execute() throws MojoExecutionException, MojoFailureException {
        SecretKey secretKey;
        try {
            secretKey = KeyGenerator.getInstance("AES").generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new MojoExecutionException(e.getMessage());
        }
        getLog().debug(propName + "");
        String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        getLog().debug("Secret key property -> " + propName + " " + encodedKey);
        project.getProperties().setProperty(propName, encodedKey);
    }
}
