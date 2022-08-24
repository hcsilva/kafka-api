package com.henrique.strconsumer.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;

//@Retention, avisa para o Spring que a anotação deve estar disponível em tempod de execução
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) //Usaddo para criar nossas próprias anotaçãoes
@KafkaListener
public @interface StrConsumerListener {

    @AliasFor(annotation = KafkaListener.class, attribute = "topics")
    String[] topic() default "str-topic";

    @AliasFor(annotation = KafkaListener.class, attribute = "containerFactory")
    String containerFactory() default "strContainerFactory";

    @AliasFor(annotation = KafkaListener.class, attribute = "groupId")
    String groupId() default "";

    @AliasFor(annotation = KafkaListener.class, attribute = "errorHandler")
    String errorHandler() default "errorCustomHandler";

}
