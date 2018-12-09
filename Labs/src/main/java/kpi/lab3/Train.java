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

    private Logger2 logger;

    public Train(Place destination, int number, LocalTime date, int seatsCommon,
                 int seatsCoupe, int seatsPlacard, int seatsCB, Logger2 logger) throws Exception2 {
        this.logger = logger;
        this.destination = destination;
        setNumber(number);
        this.date = date;
        setSeatsCommon(seatsCommon);
        setSeatsCoupe(seatsCoupe);
        setSeatsPlacard(seatsPlacard);
        setSeatsCB(seatsCB);
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

    public void setNumber(int number) throws Exception2 {
        if (number > 0)
            this.number = number;
        else throw new Exception2("not correct enter the number of train. Can`t be < 1", logger);
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

    public void setSeatsCommon(int seatsCommon) throws Exception2 {
        if (seatsCommon >= 0)
            this.seatsCommon = seatsCommon;
        else throw new Exception2("not correct enter the common seats. Can`t be < 0", logger);
    }

    public int getSeatsCoupe() {
        return seatsCoupe;
    }

    public void setSeatsCoupe(int seatsCoupe) throws Exception2 {
        if (seatsCoupe >= 0)
            this.seatsCoupe = seatsCoupe;
        else throw new Exception2("not correct enter the coupe seats. Can`t be < 0", logger);
    }

    public int getSeatsPlacard() {
        return seatsPlacard;
    }

    public void setSeatsPlacard(int seatsPlacard) throws Exception2 {
        if (seatsPlacard >= 0)
            this.seatsPlacard = seatsPlacard;
        else throw new Exception2("not correct enter the placard seats. Can`t be < 0", logger);
    }

    public int getSeatsCB() {
        return seatsCB;
    }

    public void setSeatsCB(int seatsCB) throws Exception2 {
        if (seatsCB >= 0)
            this.seatsCB = seatsCB;
        else throw new Exception2("not correct enter the CB seats. Can`t be < 0", logger);
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
