import React, {useState} from 'react'
import RepeatIcon from '@mui/icons-material/Repeat'
import {Button, Menu, MenuItem, Avatar} from '@mui/material'
import {useNavigate} from 'react-router-dom'
import MoreHorizIcon from '@mui/icons-material/MoreHoriz'
import ChatBubbleOutlineIcon from '@mui/icons-material/ChatBubbleOutline';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import FileUploadIcon from '@mui/icons-material/FileUpload';
import BarChartIcon from '@mui/icons-material/BarChart';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ReplyModal from './ReplyModal'

const TweetCard = () => {
    const navigate = useNavigate()
    const [anchorEl, setAnchorEl] = React.useState(null);
    const open = Boolean(anchorEl);
    const [openReplyModal, setOpenReplyModal] = useState(false);
    const handleOpenReplyModel = () => setOpenReplyModal(true);
    const handleCloseReplyModal = () => setOpenReplyModal(false);

    const handleClick = (event) => {
        setAnchorEl(event.currentTarget);
    };
    const handleClose = () => {
        setAnchorEl(null);
    };

    const handleDeleteTweet = () => {
        console.log("delete tweet")
        handleClose()
    }

    const handleCreateRetweet = () => {
        console.log("create retweet")
    }

    const handleLiketweet = () => {
        console.log("like tweet")
    }
    return (
        <React.Fragment>
            {/* <div className='flex items-center font-semibold text-gray-700 py-2'>
                <RepeatIcon />
                <p>You Retweet</p>
            </div> */}
            <div className='flex space-x-5'>
                <Avatar className='cursor-pointer' alt='' src='' onClick={() => navigate(`/profile/${6}`)}/>
                <div className='w-full'>
                    <div className='flex justify-between items-center'>
                        <div className='flex cursor-pointer items-center space-x-2'>
                            <span className='font-semibold'>Code with Bazunaka!</span>
                            <span className='text-gray-600'>@Bazunaka . 2мин</span>
                            <img className='ml-2 w-5 h-5' src={require('./../../img/verify_icon_227246.png')} alt=""/>
                        </div>
                        <div>
                            <Button id="basic-button" aria-controls={open ? 'basic-menu' : undefined}
                                    aria-haspopup="true" aria-expanded={open ? 'true' : undefined}
                                    onClick={handleClick}>
                                <MoreHorizIcon/>
                            </Button>
                            <Menu
                                id="basic-menu"
                                anchorEl={anchorEl}
                                open={open}
                                onClose={handleClose}
                                MenuListProps={{
                                    'aria-labelledby': 'basic-button',
                                }}
                            >
                                <MenuItem onClick={handleDeleteTweet}>Удалить</MenuItem>
                                <MenuItem onClick={handleDeleteTweet}>Отредектировать</MenuItem>
                            </Menu>
                        </div>
                    </div>
                    <div className='mt-2'>
                        <div onClick={() => navigate(`/tweet/${3}`)} className='cursor-pointer'>
                            <p className='mb-2 p-0'>Тестовое сообщение!</p>
                            <img className='w-[28rem] border border-gray-400 p-5 rounded-md'
                                 src={require('./../../img/Vw6h8fR2Ic1urCfu.png')} alt=""/>
                        </div>
                        <div className='py-5 flex flex-wrap justify-between items-center'>
                            <div className='space-x-3 flex items-center text-gray-600'>
                                <ChatBubbleOutlineIcon className='cursor-pointer' onClick={handleOpenReplyModel}/>
                                <p>43</p>
                            </div>
                            <div className={`${true ? "text-pink-600" : "text-gray-600"} space-x-3 flex items-center`}>
                                <RepeatIcon
                                    onClick={handleCreateRetweet}
                                    className='cursor-pointer'/>
                                <p>54</p>
                            </div>
                            <div className={`${true ? "text-pink-600" : "text-gray-600"} space-x-3 flex items-center`}>
                                {true ? <FavoriteIcon className='cursor-pointer'
                                                      onClick={handleLiketweet}/> :
                                    <FavoriteBorderIcon className='cursor-pointer'
                                                        onClick={handleLiketweet}/>}
                                <p>54</p>
                            </div>
                            <div className='space-x-3 flex items-center text-gray-600'>
                                <BarChartIcon className='cursor-pointer' onClick={handleOpenReplyModel}/>
                                <p>430</p>
                            </div>
                            <div className='space-x-3 flex items-center text-gray-600'>
                                <FileUploadIcon className='cursor-pointer' onClick={handleOpenReplyModel}/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <section>
                <ReplyModal open={openReplyModal} handleClose={handleCloseReplyModal}/>
            </section>
        </React.Fragment>
    )
}

export default TweetCard