import React, { Component } from 'react'
import CapacitanceService from '../services/CapacitanceService';

class CreateCapacitanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                multiplier: '',
                unit: ''
        }
        this.changeMultiplierHandler = this.changeMultiplierHandler.bind(this);
        this.changeUnitHandler = this.changeUnitHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            CapacitanceService.getCapacitanceById(this.state.id).then( (res) =>{
                let capacitance = res.data;
                this.setState({
                    multiplier: capacitance.multiplier,
                    unit: capacitance.unit
                });
            });
        }        
    }
    saveOrUpdateCapacitance = (e) => {
        e.preventDefault();
        let capacitance = {
                capacitanceId: this.state.id,
                multiplier: this.state.multiplier,
                unit: this.state.unit
            };
        console.log('capacitance => ' + JSON.stringify(capacitance));

        // step 5
        if(this.state.id === '_add'){
            capacitance.capacitanceId=''
            CapacitanceService.createCapacitance(capacitance).then(res =>{
                this.props.history.push('/capacitances');
            });
        }else{
            CapacitanceService.updateCapacitance(capacitance).then( res => {
                this.props.history.push('/capacitances');
            });
        }
    }
    
    changeMultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeUnitHandler= (event) => {
        this.setState({unit: event.target.value});
    }

    cancel(){
        this.props.history.push('/capacitances');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Capacitance</h3>
        }else{
            return <h3 className="text-center">Update Capacitance</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Multiplier: </label>
                                            #formFields( $attribute, 'create')
                                            <label> Unit: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateCapacitance}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                   </div>
            </div>
        )
    }
}

export default CreateCapacitanceComponent
