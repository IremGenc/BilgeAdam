document.addEventListener('DOMContentLoaded', function () {
    updateTable();

    document.getElementById('addCategoryBtn').addEventListener('click', function () {
        var name = document.getElementById('name').value;

        fetch('http://localhost:8081/api/product', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ name: name }),
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Failed to add product');
                }
                return response.json();
            })
            .then(() => {
                document.getElementById('name').value = '';
                updateTable();
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    });
});

function updateTable() {
    fetch('http://localhost:8081/api/product/all', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to fetch product');
            }
            return response.json();
        })
        .then(data => {
            var tableBody = document.getElementById('addCategoryBtn').getElementsByTagName('tbody')[0];
            tableBody.innerHTML = '';

            data.forEach(function (product) {
                var row = "<ul>" +
                    "<li>" + product.id + "</li>" +
                    "<li>" + product.name + "</li>" +
                    "<li>" +
                    "<button type='button' class='btn btn-info' data-toggle='modal' data-target='#editModal' onclick='openEditModal(" + product.id + ")'>Edit</button> | " +
                    "<button type='button' class='btn btn-danger' onclick='deleteCategory(" + product.id + ")'>Delete</button>" +
                    "</li>" +
                    "</ul>";

                tableBody.innerHTML += row;
            });
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}

function openEditModal(id) {
    fetch('http://localhost:8081/api/product/' + id, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to fetch product');
            }
            return response.json();
        })
        .then(category => {
            document.getElementById('editProductId').value = product.id;
            document.getElementById('editProductName').value = category.name;

            $('#editModal').modal('show');
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}

function editCategory() {
    var id = document.getElementById('editCategoryId').value;
    var newName = document.getElementById('editCategoryName').value;

    fetch('http://localhost:8081/api/category', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ id: id, name: newName }),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to edit category');
            }
            $('#editModal').modal('hide');
            updateTable();
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}

function deleteCategory(id) {
    if (confirm('Are you sure you want to delete this category?')) {
        fetch('http://localhost:8081/api/category/' + id, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
            },
        })
            .then(response => {
                if (response.ok) {
                    updateTable();
                } else {
                    throw new Error('Failed to delete category');
                }
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    }
}
