package io.github.themoddedchicken.WebConnect.lib.records;

import io.github.themoddedchicken.WebConnect.lib.annotations.sql.Field;
import io.github.themoddedchicken.WebConnect.lib.annotations.sql.Table;

import java.sql.Date;

@Table("guests")
public class Guest {
	@Field("UNIQUE PRIMARY KEY")	String 	id;
	@Field("NOT NULL") 				Date 	expires;
	@Field("NOT NULL") 				String 	host_id;

	public static Guest create(
		String id,
		Date expires,
		String host_id
	) {
		Guest guest = new Guest();

		guest.id = id;
		guest.expires = expires;
		guest.host_id = host_id;

		return guest;
	}
}
