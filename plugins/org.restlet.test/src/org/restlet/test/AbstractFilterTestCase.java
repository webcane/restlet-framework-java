/*
 * Copyright 2005-2006 Noelios Consulting.
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the "License").  You may not use this file except
 * in compliance with the License.
 *
 * You can obtain a copy of the license at
 * http://www.opensource.org/licenses/cddl1.txt
 * See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * HEADER in each file and include the License file at
 * http://www.opensource.org/licenses/cddl1.txt
 * If applicable, add the following below this CDDL
 * HEADER, with the fields enclosed by brackets "[]"
 * replaced with your own identifying information:
 * Portions Copyright [yyyy] [name of copyright owner]
 */
package org.restlet.test;

import org.restlet.Call;
import org.restlet.Filter;
import org.restlet.Restlet;

/**
 * Tests where every Filter should run through.
 * @author Lars Heuer (heuer[at]semagia.com) <a href="http://www.semagia.com/">Semagia</a>
 * @version $Rev:$ - $Date:$
 */
public abstract class AbstractFilterTestCase extends RestletTestCase
{
	/**
	 * Returns a Filter to be used for the tests. 
	 * @return Filter instance.
	 */
	protected abstract Filter getFilter();

	/**
	 * Returns a call. 
	 * @return Call instance.
	 */
	protected abstract Call getCall();

	/**
	 * Returns a restlet. 
	 * @return Restlet instance.
	 */
	protected abstract Restlet getRestlet();

	/**
	 * Returns a restlet class. 
	 * @return Restlet class.
	 */
	protected abstract Class getRestletClass();

	/**
	 * Test Restlet instance attaching/detaching. 
	 */
	public void testAttachDetachInstance() throws Exception
	{
		Filter filter = getFilter();
		assertFalse(filter.hasTarget());
		filter.setTarget(getRestlet());
		filter.start();
		assertTrue(filter.isStarted());
		assertFalse(filter.isStopped());
		Call call = getCall();
		filter.handle(call);
		assertTrue(filter.hasTarget());
		filter.setTarget(null);
		assertFalse(filter.hasTarget());
	}

	/**
	 * Test with null target. 
	 */
	public void testIllegalTarget() throws Exception
	{
		Filter filter = getFilter();
		filter.start();
		assertTrue(filter.isStarted());
		assertFalse(filter.isStopped());
		assertFalse(filter.hasTarget());
		Call call = getCall();
		try
		{
			filter.handle(call);
			fail("Filter handles call without a target");
		}
		catch (Exception ex)
		{
			// noop.
		}
	}

	/**
	 * Test not started Filter. 
	 */
	public void testIllegalStartedState() throws Exception
	{
		Filter filter = getFilter();
		filter.setTarget(getRestlet());
		assertTrue(filter.hasTarget());
		assertFalse(filter.isStarted());
		assertTrue(filter.isStopped());
		Call call = getCall();
		try
		{
			filter.handle(call);
			fail("Filter handles call without being started");
		}
		catch (Exception ex)
		{
			// noop.
		}
	}

}
