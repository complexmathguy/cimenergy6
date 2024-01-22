import React, { Component } from 'react'
import GovSteamCCService from '../services/GovSteamCCService'

class ViewGovSteamCCComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govSteamCC: {}
        }
    }

    componentDidMount(){
        GovSteamCCService.getGovSteamCCById(this.state.id).then( res => {
            this.setState({govSteamCC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovSteamCC Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovSteamCCComponent
