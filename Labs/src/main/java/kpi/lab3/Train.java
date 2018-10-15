package kpi.lab3;

import java.time.LocalTime;

public class Train {

    private Place destination;
    private int number;
    private LocalTime date;
    private int seatsCommon;
    private int seatsCoupe;
    private int seatsPlacard;
    private int seatsCB;

    public Train() {
    }

    public Train(Place destination, int number, LocalTime date, int seatsCommon,
                 int seatsCoupe, int seatsPlacard, int seatsCB) throws Exception {
        this.destination = destination;
        if (number > 0)
            this.number = number;
        else throw new Exception("not correct enter the number of train. Can`t be < 1");
        this.date = date;
        if (seatsCommon >= 0)
            this.seatsCommon = seatsCommon;
        else throw new Exception("not correct enter the common seats. Can`t be < 0");
        if (seatsCoupe >= 0)
            this.seatsCoupe = seatsCoupe;
        else throw new Exception("not correct enter the coupe seats. Can`t be < 0");
        if (seatsPlacard >= 0)
            this.seatsPlacard = seatsPlacard;
        else throw new Exception("not correct enter the placard seats. Can`t be < 0");
        if (seatsCB >= 0)
            this.seatsCB = seatsCB;
        else throw new Exception("not correct enter the CB seats. Can`t be < 0");
    }

    public Place getDestination() {
        return destination;
    }

    public void setDestination(Place destination) {
        this.destination = destination;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalTime getDate() {
        return date;
    }

    public void setDate(LocalTime date) {
        this.date = date;
    }

    public int getSeatsCommon() {
        return seatsCommon;
    }

    public void setSeatsCommon(int seatsCommon) {
        this.seatsCommon = seatsCommon;
    }

    public int getSeatsCoupe() {
        return seatsCoupe;
    }

    public void setSeatsCoupe(int seatsCoupe) {
        this.seatsCoupe = seatsCoupe;
    }

    public int getSeatsPlacard() {
        return seatsPlacard;
    }

    public void setSeatsPlacard(int seatsPlacard) {
        this.seatsPlacard = seatsPlacard;
    }

    public int getSeatsCB() {
        return seatsCB;
    }

    public void setSeatsCB(int seatsCB) {
        this.seatsCB = seatsCB;
    }

    @Override
    public String toString() {
        return "Train №" +number+
                "\nDestination: " + destination +
                "\nDeparture time: " + date +
                "\nAll seats: " + (seatsCommon+seatsCoupe+seatsPlacard+seatsCB) +
                "(Common seats: " + seatsCommon +
                ", Coupe seats: " + seatsCoupe +
                ", Placard seats: " + seatsPlacard +
                ", CB seats: " + seatsCB + ')' +
                "\n--------------------------------\n";
    }
}
