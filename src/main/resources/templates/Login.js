import './style-login.css'

const Login = () => {
    return (
        <div className='signin'>
            <div className='container'>
                <div className='row justify-content-center'>
                    <div className='col-md-4'>
                        <form class="form-signin">
                            <h3 className='h3 mb-3 font-weight-normal'>Войдите пожалуйста</h3>
                            <label for="inputEmail" class="sr-only">Email</label>
                            <input type="email" id="inputEmail" class="form-control" placeholder="Email" required="" autofocus=""/>
                            <label for="inputPassword" class="sr-only">Пароль</label>
                            <input type="password" id="inputPassword" class="form-control" placeholder="Пароль" required=""/>
                            <div class="checkbox mb-3">
                                <label>
                                <input type="checkbox" value="remember-me"/> Запомнить меня
                                </label>
                            </div>
                            <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
                        </form>
                    </div>
                </div>
            </div>
        </div> 
     );
}
 
export default Login;