package com.ibm.cics.cbmp;

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

import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.MojoExecutionException;

import com.ibm.cics.bundle.parts.BundleResource;

public abstract class BundlePartBinding {

	private com.ibm.cics.cbmp.Artifact artifact;
	
	public void setArtifact(com.ibm.cics.cbmp.Artifact artifact) {
		this.artifact = artifact;	
	}
	
	public boolean matches(Artifact a) {
		return artifact.matches(a);
	}

	public final BundleResource toBundlePart(Artifact artifact, DefaultsProvider mojo) throws MojoExecutionException {
		applyDefaults(artifact, mojo);
		return toBundlePartImpl(artifact);
	}
	
	protected abstract void applyDefaults(Artifact artifact, DefaultsProvider mojo) throws MojoExecutionException;
	
	protected abstract BundleResource toBundlePartImpl(Artifact artifact) throws MojoExecutionException;
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + artifact;
	}
}
