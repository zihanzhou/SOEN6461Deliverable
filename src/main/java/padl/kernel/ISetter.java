/*******************************************************************************
 * Copyright (c) 2001-2014 Yann-Ga�l Gu�h�neuc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Yann-Ga�l Gu�h�neuc and others, see in file; API and its implementation
 ******************************************************************************/
package padl.kernel;

/**
 * @author Yann-Ga�l Gu�h�neuc
 * @since  2005/08/05
 */
public interface ISetter extends IMethod {
	String LOGO = "\"S\"";

	int getCardinality();
	void setCardinality(final int aCardinality);
}
