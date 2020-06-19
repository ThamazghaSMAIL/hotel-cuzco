package src.domain;

import java.time.LocalDate;

public class Reservation {

	private int room;
	private LocalDate checkinDate;
	private LocalDate checkoutDate;

	public Reservation(int room, LocalDate checkinDate, LocalDate checkoutDate) {
		this.room = room;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public LocalDate getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(LocalDate checkinDate) {
		this.checkinDate = checkinDate;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

}
