import { useForm } from 'react-hook-form';
import './style-PersonalAccount.css'


const PersonalAccountUser = () => {
    const {
        register,
        handleSubmit,
        formState: { errors, isValid },
      } = useForm({
        mode: "onBlur"
      });
    
      const onSubmit = (data)=> {
        console.log (JSON.stringify(data))
      }

      const fileSubmit = (data) => {
        console.log (JSON.stringify(data))
      }

    return ( 
    <>
    <div className="container">
        <div className='row justify-content-center'>
            <div className='col-md-12'>
                <h1 className='title-user'>Личный кабинет</h1>
            </div>
        </div>
    </div>
    
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
                <input className='btn-submit' type="submit" disabled ={!isValid} value='Сохранить'/>
            </div>
            </div>
        </div>
    </form>
    <form onSubmit={handleSubmit(fileSubmit)}>
        <div className='container'>
            <div className='row justify-content-center'>
                <div className='col-md-6'>
                <label className='label-specialty'>
                Загрузите файл
                <input className='fileUp' type="file" {...register("fileUp",
                {required: "Поле надо заполнить"}
                )
               }/>
                </label>
                </div>
                <div style={{color: 'blue'}}>
                {errors?.fileUp && <p>{errors?.fileUp?.message || "Вы не отправили файл" }</p>}
                </div>
                <div className = 'col-md-6'>
                    <input className = 'btn-submitFile' type="submit" value='Отправить'/>
                </div>
            </div>
        </div>
    </form>
    </> );
}
 
export default PersonalAccountUser;