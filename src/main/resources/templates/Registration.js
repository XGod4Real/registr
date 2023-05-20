import { useForm } from 'react-hook-form';
import './style-registration.css'

const Registration = () => {
    const {
        register,
        handleSubmit,
        watch,
        reset,
        formState: { errors, isValid },
      } = useForm({
        mode: "onBlur"
      });
    
      const onSubmit = (data)=> {
        console.log (JSON.stringify(data))
        reset()
      }
      const form = document.querySelector('form');
      form.addEventListener('submit', async event => {
        event.preventDefault();

        const formData = new FormData(form);
        const json = JSON.stringify(Object.fromEntries(formData.entries()));

        const response = await fetch('/api/users/', {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: json
        });

        if (response.ok) {
          alert('Регистрация прошла успешно!');
        } else {
          alert('Ошибка регистрации');
        }
      });
    return ( 
        <main>
            <div className="container">
                <div className = "row">
                    <div className="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <h1>Регистрация</h1>
                        <p>Пожалуйста, заполните эту форму, чтобы создать учетную запись.</p>
                        <hr/>
                        <form onSubmit={handleSubmit(onSubmit)}>
                            <div className='container'>
                                <div className='row justify-content-center'>
                                <div className='col-md-6'>
                                <label className='label-firstName'>
                                    Имя
                                <input className='firstName'
                                {...register('firstName', 
                                {required: "Поле надо заполнить",
                                minLength:{value: 2, message: "Странное у вас имя"}
                                })}
                                /> 
                                </label>
                                <div style={{color: 'blue'}}>
                                    {errors?.firstName && <p>{errors?.firstName?.message || "Имени у вас нет" }</p>}
                                </div>
                                </div>
                                </div>
                                <div className='row justify-content-center'>
                                <div className='col-md-6'>
                                    <label className='label-lastName'>
                                    Фамилия
                                    <input className='lastName'
                                    {...register('lastName', 
                                    {required: "Поле надо заполнить",
                                    minLength:{value: 3, message: "Странное у вас фамилия"}
                                    })}
                                    /> 
                                    </label>
                                    <div style={{color: 'blue'}}>
                                    {errors?.lastName && <p>{errors?.lastName?.message || "Фамилии у вас нет" }</p>}
                                    </div>
                                </div>
                                </div>
                                <div className='row justify-content-center'>
                                <div className='col-md-6'>
                                    <label className='label-email'>
                                    Email
                                    <input className='email'
                                    {...register('email', 
                                    {required: "Поле надо заполнить",
                                    minLength:{value: 3, message: "где Email?"}
                                    })}
                                    /> 
                                    </label>
                                    <div style={{color: 'blue'}}>
                                    {errors?.email && <p>{errors?.email?.message || "где Email?" }</p>}
                                    </div>
                                </div>
                                </div>
                                <div className='row justify-content-center'>
                                <div className='col-md-6'>
                                    <label className='label-password'>
                                    Пароль
                                    <input className='password'
                                    type={'password'}
                                    {...register('password', 
                                    {required: "Поле надо заполнить",
                                    })}
                                    /> 
                                    </label>
                                    <div style={{color: 'blue'}}>
                                    {errors?.password && <p>{errors?.password?.message || "где Email?" }</p>}
                                    </div>
                                </div>
                                </div>
                                <div className='row justify-content-center'>
                                <div className='col-md-6'>
                                <label className='label-secondPassword'>
                                    Повторите пароль
                                <input className='secondPassword'
                                type={'password'}
                                {...register('secondPassword', 
                                {required: "Поле надо заполнить",
                                validate: (val) => {
                                    if (watch('password') !== val) {
                                    return "Правильно повторите пароль";
                                    }
                                },
                                })}
                                /> 
                                </label>
                                <div style={{color: 'blue'}}>
                                    {errors?.secondPassword && <p>{errors?.secondPassword?.message || "Неверный пароль" }</p>}
                                </div>
                                </div>
                                </div>
                                <div className='row justify-content-center'>
                                <div className='col-md-3'>
                                    <label className='label-bDate'>
                                    Дата рождения
                                    <input
                                    className='bDate'
                                    type='date'
                                    {...register('bDate', 
                                    {required: "Поле надо заполнить",
                                    
                                    })}
                                    /> 
                                    </label>
                                    <div style={{color: 'blue'}}>
                                    {errors?.bDate && <p>{errors?.bDate?.message || " " }</p>}
                                    </div>
                                </div>
                                <div className='col-md-3'>
                                    <label className ='label-phone'>
                                    Номер телефона
                                    <input
                                    className ='phone'
                                    {...register('phone', 
                                    {required: "Поле надо заполнить",
                                    
                                    })}
                                    /> 
                                    </label>
                                    <div style={{color: 'blue'}}>
                                    {errors?.phone && <p>{errors?.phone?.message || " " }</p>}
                                    </div>
                                </div>
                                </div>
                                
                                <div className='row justify-content-center'>
                                <div className='col-md-3'>
                                    <label className='label-country'>
                                    Страна
                                    <input className='country'
                                    {...register('country', 
                                    {required: "Поле надо заполнить",
                                    minLength:{value: 3, message: "где Email?"}
                                    })}
                                    /> 
                                    </label>
                                    <div style={{color: 'blue'}}>
                                    {errors?.country && <p>{errors?.country?.message || "Надо заполнить" }</p>}
                                    </div>
                                </div>
                                <div className='col-md-3'>
                                    <label className='label-city'>
                                    Город
                                    <input className='city'
                                    {...register('city', 
                                    {required: "Поле надо заполнить",
                                    minLength:{value: 3, message: "где Email?"}
                                    })}
                                    /> 
                                    </label>
                                    <div style={{color: 'blue'}}>
                                    {errors?.city && <p>{errors?.city?.message || "Надо заполнить" }</p>}
                                    </div>
                                </div>
                                </div>
                                <div className='row justify-content-center'>
                                <div className='col-md-3'>
                                    <label className='label-university'>
                                    ВУЗ
                                    <input className='university'
                                    {...register('university', 
                                    {required: "Поле надо заполнить",
                                    minLength:{value: 3, message: "где Email?"}
                                    })}
                                    /> 
                                    </label>
                                    <div style={{color: 'blue'}}>
                                    {errors?.university && <p>{errors?.university?.message || "Надо заполнить" }</p>}
                                    </div>
                                </div>
                                <div className='col-md-3'>
                                    <label className='label-specialty'>
                                    Специальность
                                    <input className='specialty'
                                    {...register('specialty', 
                                    {required: "Поле надо заполнить",
                                    minLength:{value: 6, message: "Нужно ввести полное название специальности"}
                                    })}
                                    /> 
                                    </label>
                                    <div style={{color: 'blue'}}>
                                    {errors?.specialty && <p>{errors?.specialty?.message || "Надо заполнить" }</p>}
                                    </div>
                                </div>

                                </div>

                                <div className='row justify-content-center'>
                                <div className='col-md-2'>
                                    <label className='label-level'>
                                    Курс
                                    <input className='level'
                                    type='number'
                                    {...register('level', 
                                    {required: "Поле надо заполнить",
                                    })}
                                    /> 
                                    </label>
                                    <div style={{color: 'blue'}}>
                                    {errors?.level && <p>{errors?.level?.message || "Надо заполнить" }</p>}
                                    </div>
                                </div>
                                <div className='col-md-4'>
                                    <div className="form-check">
                                    <input className="form-check-input" type="checkbox" 
                                    {...register('check', 
                                    {required: "Поле надо заполнить",
                                    })}
                                    />
                                    <label className="form-check-label" >
                                        Согласие на обработку персональных данных
                                    </label>
                                    </div>
                                    <div style={{color: 'blue'}}>
                                        {errors?.check && <p>{errors?.check?.message || "Надо заполнить" }</p>}
                                    </div>
                                </div>
                                </div>
                                <div className='row justify-content-center'>
                                <div className='col-md-4'>
                                    <input className='btn-submit' type="submit" disabled ={!isValid}/>
                                </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </main>
     );
}
 
export default Registration;
