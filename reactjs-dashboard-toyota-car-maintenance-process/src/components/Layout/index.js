import { useState } from 'react'
import { Outlet } from 'react-router-dom'
import Sidebar from 'scenes/global/Sidebar'
import Topbar from 'scenes/global/Topbar'

const Layout = () => {
  const [isSidebar, setIsSidebar] = useState(true)

  return (
    <div className="app">
      <Sidebar isSidebar={isSidebar} />
      <main className="content">
        <Topbar setIsSidebar={setIsSidebar} />
        <Outlet />
      </main>
    </div>
  )
}

export default Layout
