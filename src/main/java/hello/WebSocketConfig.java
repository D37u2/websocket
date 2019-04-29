package hello;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //针对消息订阅，配置一个或多个前缀来筛选
        //例如 /topic/greetings
        config.enableSimpleBroker("/topic");

        //目标头开头（/app）的STOMP消息将路由到@Controller类中的@MessageMapping方法。
        //例如 /app/hello
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        //设置websocket连接
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }

}