/*
 * Copyright 2005-2008 Noelios Consulting.
 * 
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License (the "License"). You may not use this file except in
 * compliance with the License.
 * 
 * You can obtain a copy of the license at
 * http://www.opensource.org/licenses/cddl1.txt See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * When distributing Covered Code, include this CDDL HEADER in each file and
 * include the License file at http://www.opensource.org/licenses/cddl1.txt If
 * applicable, add the following below this CDDL HEADER, with the fields
 * enclosed by brackets "[]" replaced with your own identifying information:
 * Portions Copyright [yyyy] [name of copyright owner]
 */
package org.restlet.test.jaxrs.services.resources;

import javax.ws.rs.Path;
import org.restlet.test.jaxrs.services.tests.InheritAnnotationTest;

/**
 * @author Stephan Koops
 * @see InheritAnnotationTestServiceInterface
 * @see InheritAnnotationTest
 */
@Path("abcd")
public class InheritAnnotationTestService1 implements
        InheritAnnotationTestServiceInterface {

    public static final String RETURN_STRING = "getTextWithoutSubResource";

    public String getText() {
        return RETURN_STRING;
    }
}