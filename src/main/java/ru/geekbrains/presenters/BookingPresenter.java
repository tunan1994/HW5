package ru.geekbrains.presenters;

import ru.geekbrains.models.Table;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private Collection<Table> tables;

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view){
        this.model = model;
        this.view = view;
        this.view.setObserver(this);
    }

    /**
     * Получение списка всех столиков
     */
    public void loadTables(){
        tables = model.loadTables();
    }

    /**
     * Отобразить список всех столиков
     */
    public void updateView(){
        view.showTables(tables);
    }

    public void updateReservationTableStatus(int reservationId){
        view.showReservationTableStatus(reservationId);
    }

    @Override
    public void onReservationTable(Date reservationDate, int tableNo, String name) {
        int reservationId = model.reservationTable(reservationDate, tableNo, name);
        updateReservationTableStatus(reservationId);
    }

    @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        int reservationId = model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
        updateReservationTableStatus(reservationId);
    }

    @Override
    public void onDeleteReservationTable(int idTable) {
        model.deleteReservationTable(idTable);
    }

    @Override
    public void onShowReservationsOnTable(int idTable) {
        model.showReservationsOnTable(idTable);
    }

}