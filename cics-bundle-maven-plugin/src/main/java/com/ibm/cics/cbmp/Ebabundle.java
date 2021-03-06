package com.ibm.cics.cbmp;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.MojoExecutionException;

import com.ibm.cics.bundle.parts.EbaBundlePart;

/*-
 * #%L
 * CICS Bundle Maven Plugin
 * %%
 * Copyright (C) 2019 IBM Corp.
 * %%
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 * #L%
 */

public class Ebabundle extends AbstractNameableJavaBundlePartBinding {
	
	@Override
	public EbaBundlePart toBundlePartImpl(Artifact artifact) throws MojoExecutionException {
		return new EbaBundlePart(
			getName(),
			getJvmserver(),
			artifact.getFile()
		);
	}

}
