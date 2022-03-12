/*
    This is an abstract class that includes all the requests types
    available as static variables
 */
package server.utils;


public abstract class Requests {
    
    //Authentication related
    public static final String SIGN_IN = "signin";
    public static final String SIGN_UP = "signup";
    public static final String CLOSE = "close";
    public static final String SIGN_OUT = "signout";

    //Player related
    public static final String SEND_INVITATION = "invitePlayer";
    public static final String INVITATION_RESPONSE = "invitationResponse";
    public static final String RECEIVE_INVITATION = "invitation";
    public static final String UPDATE_SCORE = "updateScore";
    public static final String UPDATE_STATUS = "updateStatus";
    
    //Game related
    public static final String GAME_STARTED = "gameStarted";
    
    public static final String GAME_ENDED = "gameEnded";
    public static final String GAME_QUIT = "gameQuit";
    
    public static final String GAME_SAVE = "saveGame";
    public static final String GAME_LOAD = "loadGame";
    public static final String GET_SAVED_GAMES = "getGames";
    
    public static final String GAME_MOVE = "sendMove";
    public static final String CHAT_MSG = "sendChat";

    //Unkown requests
    public static final String UNKNOWN = "unknown";
    
    //List
    public static final String UPDATE_LIST = "updateList";
    
}

