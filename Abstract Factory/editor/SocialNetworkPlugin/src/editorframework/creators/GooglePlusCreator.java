/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.creators;

import editorframework.interfaces.ISocialNetwork;
import editorframework.interfaces.SocialNetworkCreator;
import editorframework.socialnetworks.GooglePlusSocialNetwork;

/**
 *
 * @author gabriel
 */
public class GooglePlusCreator extends SocialNetworkCreator{
    
        @Override
    public ISocialNetwork createSocialNetwork() {
        return new GooglePlusSocialNetwork();
    }
}