package ru.geekbrains;

import ru.geekbrains.models.TableModel;
import ru.geekbrains.presenters.BookingPresenter;
import ru.geekbrains.views.BookingView;

import java.util.Date;

public class Main {

    /**
     * TODO: ДОМАШНЯЯ РАБОТА
     * Метод changeReservationTable должен ЗАРАБОТАТЬ!
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        TableModel model = new TableModel();
        BookingView view = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(model, view);

        bookingPresenter.loadTables();
        bookingPresenter.updateView();

        view.reservationTable(new Date(), 1, "Нурсултан");
        view.showReservationsOnTable(2);
        view.changeReservationTable(1001, new Date(), 5, "Александр");
        view.showReservationsOnTable(5);
        view.deleteReservationTable(1002);
        System.out.println("Стоилик удален из брони");
        view.showReservationsOnTable(5);


    }

}