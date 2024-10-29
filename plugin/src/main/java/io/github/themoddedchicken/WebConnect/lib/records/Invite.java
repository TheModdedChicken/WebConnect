package io.github.themoddedchicken.WebConnect.lib.records;

import io.github.themoddedchicken.WebConnect.lib.annotations.sql.Field;
import io.github.themoddedchicken.WebConnect.lib.annotations.sql.Table;

import java.util.UUID;

@Table("invites")
public class Invite {
	@Field("UNIQUE PRIMARY KEY")	String id;
	@Field("UNIQUE NOT NULL") 		String user_id;
	@Field("NOT NULL") 				String host_id;

	public static Invite create(
		String user_id,
		String host_id
	) {
		Invite invite = new Invite();

		invite.id = UUID.randomUUID().toString();
		invite.user_id = user_id;
		invite.host_id = host_id;

		return invite;
	}
}
