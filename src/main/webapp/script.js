async function addUser() {
  let form = document.querySelector(".create-form")

  let data = new FormData(form)

  let promise = await fetch("http://localhost:8080/web_microservice_war_exploded/user", {
    method: "POST",
    body: data
  })

  let result = await promise.text()
  let div = document.querySelector(".create-message")
  div.innerText = result
}

async function searchUser() {
  let form = document.querySelector(".retrieve-form")
  let div = document.querySelector(".retrieve-message")

  let data = new FormData(form)

  let promise = await fetch("http://localhost:8080/web_microservice_war_exploded/user", {
    method: "POST",
    body: data
  })

  let result = await promise.json()

  if (result != null) {
    div.innerHTML = `
    <p>USERNAME: ${result.userName}</p>
    <p>EMAIL: ${result.email}</p>
    <p>PASSWORD: ${result.password}</p> `
  }
  else {
    div.innerHTML = "User not found"
  }

}

async function deleteUser() {
  let form = document.querySelector(".delete-form")
  let div = document.querySelector(".delete-message")

  let data = new FormData(form)

  let promise = await fetch("http://localhost:8080/web_microservice_war_exploded/user", {
    method: "DELETE",
    body: data
  })

  let result = await promise.text()
  div.innerText = result

}
