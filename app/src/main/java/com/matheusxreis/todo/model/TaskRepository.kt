package com.matheusxreis.todo.model

class TaskRepository {
    private var tasks: List<Task> = listOf()

    fun listAll(): List<Task> = tasks;

    fun addNewTask(task: Task){
        tasks = tasks.plus(task)
    }

    fun removeTask(id: String){
        val newList = tasks.filter {
            it.id !== id
        }
        tasks = newList
    }

}