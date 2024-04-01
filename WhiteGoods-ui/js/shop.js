document.addEventListener("DOMContentLoaded", function () {
  updateTable();
});

function updateTable() {
  fetch("http://localhost:8081/api/product/all", {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("Failed to fetch categories");
      }
      return response.json();
    })
    .then((data) => {
      var product_list = document.querySelector(".product-list");

      data.forEach(function (product) {
        product_list.innerHTML =
          product_list.innerHTML +
          `<li class="product-item">
            <div class="product-image">
                <a href="#">
                    <img src="${product.image}" alt="" class="img1">

                </a>
            </div>
            <div class="product-info">
                <a href="$" class="product-title">${product.name}</a>
                <div class="product-prices">
                    <strong class="new-price">${product.price}</strong>
                    </br>
                    <button id="addToCartButton" style = "padding:2px" class="btn btn-primary">Add to Cart</button>
                </div>
            </div>
        </li>`;
      });
    })
    .catch((error) => {
      console.error("Error:", error);
    });
}

function openEditModal(id) {
  fetch("http://localhost:8081/api/product/" + id, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("Failed to fetch product");
      }
      return response.json();
    })
    .then((category) => {
      document.getElementById("editCategoryId").value = product.id;
      document.getElementById("editCategoryName").value = product.name;

      $("#editModal").modal("show");
    })
    .catch((error) => {
      console.error("Error:", error);
    });
}

function editProduct() {
  var id = document.getElementById("editProductId").value;
  var newName = document.getElementById("editProductName").value;

  fetch("http://localhost:8081/api/product", {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ id: id, name: newName }),
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("Failed to edit product");
      }
      $("#editModal").modal("hide");
      updateTable();
    })
    .catch((error) => {
      console.error("Error:", error);
    });
}

function deleteProduct(id) {
  if (confirm("Are you sure you want to delete this product?")) {
    fetch("http://localhost:8081/api/product/" + id, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => {
        if (response.ok) {
          updateTable();
        } else {
          throw new Error("Failed to delete product");
        }
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  }
}
