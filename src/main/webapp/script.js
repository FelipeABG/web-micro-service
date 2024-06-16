async function addUser() {
  let form = document.querySelector(".create-form")

  let data = new FormData(form)

  console.log(data)

  let promise = await fetch("http://localhost:8080/web_microservice_war_exploded/user", {
    method: "POST",
    body: data
  })

}
