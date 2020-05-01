/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.shell;

import editorframework.interfaces.ISocialNetwork;
import editorframework.interfaces.SocialNetworkCreator;

/**
 *
 * @author aluno
 */
public class TwitterCreator extends SocialNetworkCreator {

    @Override
    public ISocialNetwork createSocialNetwork() {
        return new TwitterSocialNetwork();
    }
    
}
