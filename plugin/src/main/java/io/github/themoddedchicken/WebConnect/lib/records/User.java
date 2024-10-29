package io.github.themoddedchicken.WebConnect.lib.records;

import io.github.themoddedchicken.WebConnect.lib.annotations.sql.Field;
import io.github.themoddedchicken.WebConnect.lib.annotations.sql.Table;

import java.sql.Date;

@Table("users")
public class User {
    @Field("UNIQUE PRIMARY KEY")    String  id;
    @Field("UNIQUE")                String  session;
    @Field("NOT NULL")              String  auth_provider_id;
    @Field()                        String  uuid;
    @Field()                        String  player_provider_id;
    @Field()                        int     guests;
    @Field()                        int     invites;
    @Field("UNIQUE")                String  guest_id;
    @Field("NOT NULL")              Date    created;

    public static User create(
        String id,
        String auth_provider_id,
        Date created
    ) {
        User user = new User();

        user.id = id;
        user.auth_provider_id = auth_provider_id;
        user.created = created;

        return user;
    }
}
