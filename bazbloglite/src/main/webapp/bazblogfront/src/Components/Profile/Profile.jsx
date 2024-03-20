import React, {useState} from 'react'
import KeyboardBackspaceIcon from '@mui/icons-material/KeyboardBackspace';
import {useNavigate} from 'react-router-dom';
import {Avatar, Button, Box, Tab} from '@mui/material'
import BusinessCenterIcon from '@mui/icons-material/BusinessCenter';
import LocationOnIcon from '@mui/icons-material/LocationOn';
import CalendarMonthIcon from '@mui/icons-material/CalendarMonth';
import TabContext from '@mui/lab/TabContext';
import TabList from '@mui/lab/TabList';
import TabPanel from '@mui/lab/TabPanel';
import TweetCard from '../HomeSection/TweetCard'
import ProfileModal from './ProfileModal';

const Profile = () => {

    const [tabValue, setTabValue] = useState("1")

    const navigate = useNavigate();

    const [openProfileModal, setOpenProfileModal] = useState(false);
    const handleOpenProfileModel = () => setOpenProfileModal(true);
    const handleClose = () => setOpenProfileModal(false);

    const handleBack = () => navigate(-1);

    const handleFollowUser = () => {
        console.log("follow user")
    }

    const handleTabChange = (event, newValue) => {
        setTabValue(newValue);

        // if (newValue === 4) {
        //     console.log("likes twit")
        // }
        // else if (newValue === 1) {
        //     console.log("users twits")
        // }
    };
    return (
        <div>
            <section className={`bg-white z-50 flex items-center sticky top-0 bg-opacity-95`}>
                <KeyboardBackspaceIcon className='cursor-pointer' onClick={handleBack}/>
                <h1 className='py-5 text-xl font-bold opacity-90 ml-5'>Code with Bazunaka</h1>
            </section>
            <section>
                <img className='w-[100%] h-[15rem] object-cover'
                     src={require('./../../img/0bb51823-25ca-43d6-93f9-23ca920a920c.jpg')} alt=""/>
            </section>
            <section className='pl-6'>
                <div className='flex justify-between items-start mt-5 h-[5rem]'>
                    <Avatar className='transform -translate-y-24' alt="code with Bazunaka" src=""
                            sx={{width: "10rem", height: "10rem", border: "4px solid white"}}/>
                    {true ? (
                        <Button
                            variant='contained'
                            onClick={handleOpenProfileModel}
                            sx={{borderRadius: "20px"}}>
                            Редактировать профиль
                        </Button>
                    ) : (
                        <Button
                            variant='contained'
                            onClick={handleFollowUser}
                            sx={{borderRadius: "20px"}}>
                            {true ? "Подписаться" : "Отписаться"}
                        </Button>)}
                </div>
                <div>
                    <div className='flex items-center'>
                        <h1 className='font-bold text-lg'>Bazunaka</h1>
                        {true && (
                            <img className='ml-2 w-5 h-5' src={require('./../../img/verify_icon_227246.png')} alt=""/>
                        )}
                    </div>
                    <h1 className='text-gray-500'>@Bazunaka</h1>
                </div>
                <div className='mt-2 space-y-3'>
                    <p>Приветствие!</p>
                    <div className='py-1 flex space-x-5'>
                        <div className='flex items-center text-gray-500'>
                            <BusinessCenterIcon/>
                            <p className='ml-2'>Образование</p>
                        </div>
                        <div className='flex items-center text-gray-500'>
                            <LocationOnIcon/>
                            <p className='ml-2'>Россия</p>
                        </div>
                        <div className='flex items-center text-gray-500'>
                            <CalendarMonthIcon/>
                            <p className='ml-2'>Присоединился тогда-то</p>
                        </div>
                    </div>
                    <div className='flex items-center space-x-5'>
                        <div className='flex items-center space-x-1 font-semibold'>
                            <span>190</span>
                            <span className='text-gray-500'>Подписок</span>
                        </div>
                        <div className='flex items-center space-x-1 font-semibold'>
                            <span>590</span>
                            <span className='text-gray-500'>Подписчиков</span>
                        </div>
                    </div>
                </div>
            </section>
            <section className='py-5'>
                <Box sx={{width: '100%', typography: 'body1'}}>
                    <TabContext value={tabValue}>
                        <Box sx={{borderBottom: 1, borderColor: 'divider'}}>
                            <TabList onChange={handleTabChange} aria-label="lab API tabs example">
                                <Tab label="Твиты" value="1"/>
                                <Tab label="Ответы" value="2"/>
                                <Tab label="Медиа" value="3"/>
                                <Tab label="Понравилось" value="4"/>
                            </TabList>
                        </Box>
                        <TabPanel value="1">{[1, 1, 1, 1].map((item) => <TweetCard/>)}</TabPanel>
                        <TabPanel value="2">Ответы пользователя</TabPanel>
                        <TabPanel value="3">Загруженные медиа</TabPanel>
                        <TabPanel value="4">Понравившиеся публикации</TabPanel>
                    </TabContext>
                </Box>
            </section>
            <section>
                <ProfileModal handleClose={handleClose} open={openProfileModal}/>
            </section>
        </div>
    )
}

export default Profile