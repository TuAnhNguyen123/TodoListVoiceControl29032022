package com.example.todolistvoicecontrol29032022.presentation.viewmodel;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.todolistvoicecontrol29032022.data.datasource.local.entities.TodoEntity;
import com.example.todolistvoicecontrol29032022.data.model.Todo;
import com.example.todolistvoicecontrol29032022.data.repository.TodoRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
public class MainViewModel extends ViewModel {
    private MutableLiveData<List<Todo>> todoLists = new MutableLiveData<>();
    private MutableLiveData<String> message = new MutableLiveData<>();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private MutableLiveData<Long> idInsert = new MutableLiveData<>();
    private MutableLiveData<Integer> update = new MutableLiveData<>();
    private MutableLiveData<Comparable> detele = new MutableLiveData<>();

    private TodoRepository repository;

    public MainViewModel(Context context) {
        repository = new TodoRepository(context);
    }

    public LiveData<List<Todo>> getTodoLists() {
        return todoLists;
    }

    public LiveData<Long> getIdInsert() {
        return idInsert;
    }

    public LiveData<Integer> getUpdate() {
        return update;
    }

    public LiveData<Comparable> delete() {
        return detele;
    }

    public LiveData<String> getMessage() {
        return message;
    }

    public LiveData<Boolean> getLoading() {
        return loading;
    }

    public void queryTodoLists() {
        loading.setValue(true);
        repository
                .getTodoLists()
                .subscribeOn(Schedulers.io())
                .map(todoEntities -> {
                    List<Todo> newTodoLists = new ArrayList<>();
                    for (TodoEntity entity : todoEntities) {
                        newTodoLists.add(new Todo(
                                entity.id,
                                entity.title,
                                entity.description,
                                entity.createTime,
                                entity.deadlineTime,
                                entity.imagePath,
                                entity.voicePath,
                                entity.priorityColor
                        ));
                    }
                    return newTodoLists;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .toObservable()
                .subscribe(new Observer<List<Todo>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<Todo> todos) {
                        todoLists.setValue(todos);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        message.setValue(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        loading.setValue(false);
                    }
                });
    }
    public void insertTodo(TodoEntity todoEntity) {
        loading.setValue(true);
        repository
                .insertTodo(todoEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toObservable()
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }
                    @Override
                    public void onNext(@NonNull Long todos) {
                        idInsert.setValue(todos);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        message.setValue(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        loading.setValue(false);
                    }
                });
    }
    public void updateTodo(TodoEntity todoEntity) {
        loading.setValue(true);
        repository
                .updateTodo(todoEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toObservable()
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }
                    @Override
                    public void onNext(@NonNull Integer todos) {
                        update.setValue(todos);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        message.setValue(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        loading.setValue(false);
                    }
                });

    }
    }