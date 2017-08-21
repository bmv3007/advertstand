package sockets;

import javax.ejb.Singleton;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Maria on 20.08.2017.
 */
@Singleton
@ServerEndpoint("/socket")
public class WebSocketServerEndPoint {

    private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());


    @OnOpen
    public void onOpen(Session session) {
        System.out.println("onOpen: " + session.getId());
        sessions.add(session);
        System.out.println("onOpen: Notification list size: " + sessions.size());
    }

    public void sendMessage() throws IOException {
        if(!sessions.isEmpty() && sessions.size()>0) {
            for (Session session : sessions) {
                session.getBasicRemote().sendText("ttt");
                System.out.println("sendText(tt)");

                //sessions.webSocket.connection.sendMessage("inf|");
            }
        }
    }


    @OnClose
    public void onClose (Session session) {
        sessions.remove(session);
        System.out.println("onClose: Notification list size: " + sessions.size());

    }

}
