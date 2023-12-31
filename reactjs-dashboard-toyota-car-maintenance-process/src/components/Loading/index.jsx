import React from 'react'

import styles from './Loading.module.scss'

const Loading = () => {
  return (
    <div className={styles.loader}>
      <div id={styles.loading}></div>
    </div>
  )
}

export default Loading
