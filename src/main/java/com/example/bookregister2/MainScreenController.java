package com.example.bookregister2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;


    @FXML
    private TableView<Book> tableView;

    @FXML
    private TableColumn<Book, String> bookAuthorColumn;

    @FXML
    private TableColumn<Book, String> bookGenreColumn;

    @FXML
    private TableColumn<Book, String> bookNameColumn;

    @FXML
    private TableColumn<Book, String> bookPresenceColumn;

    @FXML
    private TextField textFieldAuthor;

    @FXML
    private TextField textFieldGenre;

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldPresenсe;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        bookNameColumn.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        bookAuthorColumn.setCellValueFactory(new PropertyValueFactory<>("bookAuthor"));
        bookGenreColumn.setCellValueFactory(new PropertyValueFactory<>("bookGenre"));
        bookPresenceColumn.setCellValueFactory(new PropertyValueFactory<>("bookPresence"));

        tableView.setItems(getBooks());
        tableView.setEditable(true);
        bookNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        bookAuthorColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        bookGenreColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        bookPresenceColumn.setCellFactory(TextFieldTableCell.forTableColumn());

    }
    public ObservableList<Book>  getBooks()
    {
        ObservableList<Book> books = FXCollections.observableArrayList();

        books.add(new Book("Идиот", "Достоевский", "Роман", "ДА"));
        books.add(new Book("Идиот", "Достоевский", "Роман", "ДА"));
        books.add(new Book("Идиот", "Достоевский", "Роман", "ДА"));
        books.add(new Book("Идиот", "Достоевский", "Роман", "ДА"));

        return books;
    }

    @FXML
    void buttonDelete(ActionEvent event) {
        ObservableList<Book> selectedRows, allBooks;
        allBooks = tableView.getItems();

        selectedRows = tableView.getSelectionModel().getSelectedItems();

        for (Book book : selectedRows) {
            allBooks.remove(book);
        }
    }

    @FXML
    void onEditChangedAuthor(TableColumn.CellEditEvent<Book, String> bookStringCellEditEvent) {
        Book book = tableView.getSelectionModel().getSelectedItem();
        book.setBookAuthor(bookStringCellEditEvent.getNewValue());
    }

    @FXML
    void onEditChangedGenre(TableColumn.CellEditEvent<Book, String> bookStringCellEditEvent) {
        Book book = tableView.getSelectionModel().getSelectedItem();
        book.setBookGenre(bookStringCellEditEvent.getNewValue());
    }

    @FXML
    void onEditChangedName(TableColumn.CellEditEvent<Book, String> bookStringCellEditEvent) {
        Book book = tableView.getSelectionModel().getSelectedItem();
        book.setBookName(bookStringCellEditEvent.getNewValue());

    }

    @FXML
    void onEditChangedPresence(TableColumn.CellEditEvent<Book, String> bookStringCellEditEvent) {
        Book book = tableView.getSelectionModel().getSelectedItem();
        book.setBookPresence(bookStringCellEditEvent.getNewValue());
    }


    @FXML
    public void buttonAdd(ActionEvent event) {
        Book newBook = new Book(textFieldName.getText(),
                textFieldAuthor.getText(),
                textFieldGenre.getText(),
                textFieldPresenсe.getText());

        tableView.getItems().add(newBook);
    }
}