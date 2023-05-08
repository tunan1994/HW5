package ru.geekbrains.presenters;

import ru.geekbrains.models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {

    Collection<Table> loadTables();

    int reservationTable(Date reservationDate, int tableNo, String name);
    boolean deleteReservationTable(int idTable);
    int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);
    void showReservationsOnTable(int reservationId);

}