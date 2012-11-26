/**
 * Copyright (C) 2010-2012 Joerg Bellmann <joerg.bellmann@googlemail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.t7mp;

import com.googlecode.t7mp.configuration.ChainedArtifactResolver;
import com.googlecode.t7mp.steps.Context;
import com.googlecode.t7mp.steps.DefaultContext;

/**
 *
 * Takes configurations for t7 Tomcat only (no TomEE).
 *
 * @author Joerg Bellmann
 *
 */
public abstract class AbstractT7TomcatMojo extends AbstractT7BaseMojo implements T7Configuration {

    /**
     *
     * @parameter default-value="false"
     */
    protected boolean downloadTomcatExamples = false;

    /**
    *
    * @parameter default-value="true"
    */
    protected boolean deleteDefaultTomcatWebapps = true;

    /**
     * @parameter default-value="false"
     */
    protected boolean deleteTomcatDefaultRootWebapp = false;

    /**
     * @parameter default-value="false"
     */
    protected boolean deleteTomcatDefaultManagerWebapp = false;

    /**
     * @parameter default-value="false" 
     */
    protected boolean deleteTomcatDefaultHostManagerWebapp = false;

    /**
     * @parameter default-value="false"
     */
    protected boolean deleteTomcatDefaultExamplesWebapp = false;

    /**
     * @parameter default-value="false"
     */
    protected boolean deleteTomcatDefaultDocsWebapp = false;

    public void setDownloadTomcatExamples(boolean downloadTomcatExamples) {
        this.downloadTomcatExamples = downloadTomcatExamples;
    }

    @Override
    public boolean isDeleteDefaultTomcatWebapps() {
        return deleteDefaultTomcatWebapps;
    }

    public void setDownloadDefaultTomcatWebapps(boolean deleteDefaultTomcatWebapps) {
        this.deleteDefaultTomcatWebapps = deleteDefaultTomcatWebapps;
    }

    @Override
    public boolean isDeleteTomcatDefaultRootWebapp() {
        return deleteTomcatDefaultRootWebapp;
    }

    public void setDeleteTomcatDefaultRootWebapp(boolean deleteTomcatDefaultRootWebapp) {
        this.deleteTomcatDefaultRootWebapp = deleteTomcatDefaultRootWebapp;
    }

    @Override
    public boolean isDeleteTomcatDefaultManagerWebapp() {
        return deleteTomcatDefaultManagerWebapp;
    }

    public void setDeleteTomcateDefaultManagerWebapp(boolean deleteTomcatDefaultManagerWebapp) {
        this.deleteTomcatDefaultManagerWebapp = deleteTomcatDefaultManagerWebapp;
    }

    public boolean isDeleteTomcatDefaultHostManagerWebapp() {
        return deleteTomcatDefaultHostManagerWebapp;
    }

    public void setDeleteTomcatDefaultHostManagerWebapp(boolean deleteTomcatDefaultHostManagerWebapp) {
        this.deleteTomcatDefaultHostManagerWebapp = deleteTomcatDefaultHostManagerWebapp;
    }

    public boolean isDeleteTomcatDefaultExamplesWebapp() {
        return deleteTomcatDefaultExamplesWebapp;
    }

    public void setDeleteTomcatDefaultExamplesWebapp(boolean deleteTomcatDefaultExamplesWebapp) {
        this.deleteTomcatDefaultExamplesWebapp = deleteTomcatDefaultExamplesWebapp;
    }

    public boolean isDeleteTomcatDefaultDocsWebapp() {
        return deleteTomcatDefaultDocsWebapp;
    }

    public void setDeleteTomcatDefaultDocsWebapp(boolean deleteTomcatDefaultDocsWebapp) {
        this.deleteTomcatDefaultDocsWebapp = deleteTomcatDefaultDocsWebapp;
    }

    @Override
    public TomcatArtifact getTomcatArtifact() {
        return new TomcatArtifact();
    }

    protected Context buildParentContext() {
        ChainedArtifactResolver artifactResolver = new ChainedArtifactResolver();
        artifactResolver.addPluginArtifactResolver(new MyArtifactResolver(this));
        DefaultContext defaultContext = new DefaultContext(artifactResolver, this, new MavenPluginLog(getLog()));
        return defaultContext;
    }
}
