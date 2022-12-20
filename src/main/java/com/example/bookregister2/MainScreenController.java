package com.example.bookregister2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

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
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

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

        for (Book book: selectedRows)
        {
            allBooks.remove(book);
        }
    }

    public void buttonEdit(ActionEvent event) {
    }

    public void buttonAdd(ActionEvent event) {
        Book newBook = new Book(textFieldName.getText(),
                textFieldAuthor.getText(),
                textFieldGenre.getText(),
                textFieldPresenсe.getText());

        tableView.getItems().add(newBook);
    }


//    public void newPersonButtonPushed()
//    {
//        Book newBook = new Book(firstNameTextField.getText(),
//                lastNameTextField.getText(),
//
//        tableView.getItems().add(newBook);
//    }
}